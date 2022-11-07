Получение токена
-перешёл на страницу https://dev.vk.com/sdk/java и создал своё vk api "api for java"
![image](https://user-images.githubusercontent.com/114608473/200283322-253ff096-96c1-4bac-816a-b41297edf4c7.png)
-скопировал ссылку для создания токена https://oauth.vk.com/authorize?client_id=1&display=page&redirect_uri=http://example.com/callback&scope=friends&response_type=token&v=5.131&state=123456 
со страницы https://dev.vk.com/api/access-token/implicit-flow-user
-в ссылке после "client_id=" ввёл id своего приложения, добавил в "redirect_uri" страницу по умолчанию и в "scope" указал права, которые будут у токена
-скопировал получившуюся ссылку в браузер и выполнив запрос получил токен
