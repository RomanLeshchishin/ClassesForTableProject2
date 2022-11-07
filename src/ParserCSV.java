import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ParserCSV {
    ArrayList<Student> students = new ArrayList<>();
    String[] typesOfTasks;
    String[] maxPoints;
    String[] listTopics;


    public ParserCSV() throws IOException {
        var pathFile = Path.of("basicprogramming_2.csv");
        var lines = Files.readAllLines(pathFile, StandardCharsets.UTF_8);
        var dataFromFile = lines.stream().map(line -> line.split(";", -1)).toList();
        listTopics = dataFromFile.get(0);
        typesOfTasks = dataFromFile.get(1);
        maxPoints = dataFromFile.get(2);
        createStudents(dataFromFile.subList(3,dataFromFile.size() + 1));
    }
    private void createStudents(List<String[]> studentLines){
        for(String[] line : studentLines){
            students.add(createCourse(new Student(line[0], line[1]), line));
        }
    }
    private Student createCourse(Student student, String[] inf){
        var activities = Float.parseFloat(maxPoints[2]);
        var exercises = Float.parseFloat(maxPoints[3]);
        var practices = Float.parseFloat(maxPoints[4]);
        var seminarTasks = Float.parseFloat(maxPoints[5]);
        var studentScores = new Scores(activities, exercises, practices, seminarTasks);
        Topic topic = null;
        int count = 8;
        while (count < inf.length){
            var titles = Arrays.copyOfRange(typesOfTasks, count, typesOfTasks.length);

            var md = Arrays.copyOfRange(inf, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            var hw = Arrays.copyOfRange(typesOfTasks, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            var mScore = Arrays.copyOfRange(maxPoints, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            var hMaxScore = find(hw, "ДЗ") != -1 ? maxPoints[find(hw, "ДЗ") + count]: "0";

            var exercisesMaxScore = Float.parseFloat(maxPoints[count + 1]);
            var homeworkMaxScore = Float.parseFloat(hMaxScore);
            var activityMaxScore = Float.parseFloat(maxPoints[count]);
            var activityScore = Float.parseFloat(maxPoints[count + md.length - 1]);
            var semMaxScore = Float.parseFloat(md[0]);
            var semScore = Float.parseFloat(md[md.length - 1]);

            topic = new Topic(listTopics[count], exercisesMaxScore, homeworkMaxScore,
                    activityMaxScore, activityScore, semMaxScore, semScore);

            count = Arrays.asList(titles).indexOf("Сем") + count + 1;
            studentScores.addModule(addTasks(topic, md, mScore, hw));
        }
    }
    private Topic addTasks(Topic topic, String[] scores, String[] mScores, String[] names){
        for (var i = 0; i < scores.length;i++){
            var ms = Float.parseFloat(mScores[i]);
            var ps = Float.parseFloat(scores[i]);
            if(names[i].startsWith("Упр:"))
                topic.addExercise(new Task(names[i], ms, ps));
            else if (names[i].startsWith("ДЗ:"))
                topic.addHomework(new Task(names[i], ms, ps));
        }
        return topic;
    }
    private static int find(String[] a, String elem)
    {
        for (int i = 0; i < a.length; i++)
            if (Objects.equals(a[i], elem))
                return i;
        return -1;
    }
}
