# Assignment-10
# Приложение для управления сотрудниками

Это простое приложение на JavaFX для управления сотрудниками. Оно позволяет:
- Добавлять сотрудников с указанием имени, типа (Полный рабочий день, Неполный рабочий день, Контрактник), почасовой ставки и отработанных часов.
- Отображать список сотрудников в таблице.
- Рассчитывать и отображать зарплату на основе типа сотрудника и введенных данных.
- Удалять выбранных сотрудников из таблицы.

---

## Функционал

1. **Добавление сотрудников**
    - Поля ввода для данных сотрудника:
        - **Имя**
        - **Тип** (Полный рабочий день, Неполный рабочий день, Контрактник)
        - **Почасовая ставка**
        - **Отработанные часы**
    - Автоматический расчет зарплаты в зависимости от типа сотрудника:
        - **Полный рабочий день**: Предполагается 40 часов в неделю.
        - **Неполный рабочий день** и **Контрактник**: Учитываются введенные отработанные часы.

2. **Отображение списка сотрудников**
    - Сотрудники отображаются в таблице с колонками:
        - **Имя**
        - **Тип**
        - **Зарплата**

3. **Удаление сотрудников**
    - Выберите сотрудника в таблице и нажмите кнопку **Remove Employee**, чтобы удалить его.

---

## Требования

- Java Development Kit (JDK) версии 17 или выше.
- Установленный и настроенный JavaFX SDK.

---

## Как запустить

1. Клонируйте репозиторий

2.Откройте проект в вашей IDE (например, IntelliJ IDEA, Eclipse или NetBeans).

3.Убедитесь, что в проект добавлена библиотека JavaFX:
Добавьте JavaFX SDK в зависимости проекта.

4.Запустите приложение:
Найдите класс Main в пакете com.example.assignment10.
Щелкните правой кнопкой мыши и выберите Run.

##. Структура проекта

hello-view.fxml
Содержит дизайн и разметку интерфейса приложения.

HelloController.java
Реализует логику приложения, включая добавление и удаление сотрудников.

EmployeeData.java
Модельный класс, представляющий сотрудника с полями для имени, типа и зарплаты.

##. Использование

Запустите приложение.
Заполните поля Name, Type, Hourly Rate и Hours Worked.
Нажмите Add Employee, чтобы добавить сотрудника в таблицу.
Выберите сотрудника в таблице и нажмите Remove Employee, чтобы удалить его.
Повторяйте по мере необходимости.