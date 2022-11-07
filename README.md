Получение токена

1. Перешёл на страницу https://dev.vk.com/sdk/java и создал своё vk api "api for java"
![ImageVkApi](https://user-images.githubusercontent.com/114608473/200288097-abf5128d-af71-4e6d-a0e2-4745fc1782c0.jpg)
2. Скопировал ссылку для создания токена https://oauth.vk.com/authorize?client_id=1&display=page&redirect_uri=http://example.com/callback&scope=friends&response_type=token&v=5.131&state=123456 
со страницы https://dev.vk.com/api/access-token/implicit-flow-user

3. В ссылке после "client_id=" ввёл id своего приложения, добавил в "redirect_uri" страницу по умолчанию и в "scope" указал права, которые будут у токена

4. Скопировал получившуюся ссылку в браузер и выполнив запрос получил токен
