#language:ru
Функционал: динамический фрагмент

  @fragment
  Сценарий: открытие страницы и ввод текста из параметра
    * открыть url "https://www.google.ru/"
    * инициализация страницы "Google"
    * ввести в поле "поле поиска" значение "<текст_для_ввода>"