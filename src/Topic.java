import java.util.ArrayList;
public class Topic {
        private final String topicName;
        private final float exercisesMaxScore;
        private final float homeworksMaxScore;
        private final float activityMaxScore;
        private final float activityScore;
        private final float SeminarTasksMaxScore;
        private final float SeminarTasksScore;

        private final ArrayList<Task> exercisePoints = new ArrayList<>();
        private final ArrayList<Task> practicePoints = new ArrayList<>();

        public Topic(String moduleName, float exercisesMaxScore,
                      float homeworkMaxScore, float activityMaxScore,
                      float semMaxScore, float activityScore, float semScore) {
            this.topicName = moduleName;
            this.exercisesMaxScore = exercisesMaxScore;
            this.homeworksMaxScore = homeworkMaxScore;
            this.activityMaxScore = activityMaxScore;
            this.activityScore = activityScore;
            this.SeminarTasksMaxScore = semMaxScore;
            this.SeminarTasksScore = semScore;
        }

        public String getModuleName(){
            return topicName;
        }

        public float getExercisesMaxScore(){
            return exercisesMaxScore;
        }

        public float getHomeworkMaxScore(){
            return homeworksMaxScore;
        }
        public float getActivityMaxScore(){
            return activityMaxScore;
        }
        public float getActivityScore(){
            return activityScore;
        }
}
