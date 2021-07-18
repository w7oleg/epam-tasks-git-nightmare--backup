# Все задачи по Java собраны в одном Maven проекте в директории epam.java.task
# Задачи из javaStageTwo собраны в пакете javaStageTwo
1. fundamentals
2. classes
3. cleancode
4. сollections

javaStageTwo

6. javaStageTwo.errorsAndExceptions
7. javaStageTwo.ioFundamentals
8. javaStageTwo.threads

# fundamentals
 Main Task: 
 Реализовать следующие программы:
    1.1. Приветствовать любого пользователя при вводе его имени через командную строку.
    1.2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
    1.3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
    1.4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
    1.5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
    
  Optional Task Задание. Ввести n чисел с консоли.
    1.1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    1.2. Вывести числа в порядке возрастания (убывания) значений их длины
    1.3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину. 
   
# classes
    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
       5. Book: id, Название, Автор (ы), Издательство, Год издания, Количество страниц, Цена, Тип переплета.

       Создать массив объектов. Вывести:

       a) список книг заданного автора;

       b)   список книг, выпущенных заданным издательством;

       c)   список книг, выпущенных после заданного года.
      
      
# cleancode      
      Java. Clean Code Задание по aircompany
      
  # сollections
    Main task: flowergirl
    Цветочница. Определить иерархию цветов. Создать несколько объектов-цветов. Собрать букет (используя аксессуары) с определением его стоимости. Провести сортировку цветов в
    букете на основе уровня свежести. Найти цветок в букете, соответствующий заданному диапазону длин стеблей.
    additional
    one: Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
    two: Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.
    three: Задан файл с текстом на английском языке. Выделить все различные слова. Слова, отличающиеся только регистром букв, считать одинаковыми.
  # javaStageTwo.errorsAndExceptions
          В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы. У каждого студента есть несколько учебных предметов по которым он получает
          оценки. Необходимо реализовать иерархию студентов, групп и факультетов.
          Посчитать средний балл по всем предметам студента
          Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
          Посчитать средний балл по предмету для всего университета
          Релизовать следующие исключения:
          Оценка ниже 0 или выше 10
          Отсутсвие предметов у студента (должен быть хотя бы один)
          Отсутствие студентов в группе
          Отсутствие групп на факультете
          Отсутствие факультетов в университете
   # javaStageTwo.ioFundamentals
         MainTask
                    Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории, например "D:/movies". Записать в текстовый файл
                    структуру папок и файлов в виде, похожем на выполнение программы tree /F. Пример:
           Amon Amarth
               |-----2004 - Fate Of Norns
               |       01 - An Ancient Sign Of Coming Storm.mp3
               |       02 - Where Death Seems To Dwell.mp3
               |       03 - The Fate Of Norns.mp3
               |       04 - The Pursuit Of Vikings.mp3
               |       05 - Valkyries Ride.mp3
               |       06 - The Beheading Of A King.mp3
               |       07 - Arson.mp3
               |       08 - Once Sealed In Blood.mp3
               |
               |-----2016 - Jomsviking
               |       01 First Kill.mp3
               |       02 Wanderer.mp3
               |       03 On A Sea Of Blood.mp3
               |       04 One Against All.mp3
               |       05 Raise Your Horns.mp3
               |       06 The Way Of Vikings.mp3
               |       07 At Dawn’s First Light.mp3
               |       08 One Thousand Burning Arrows.mp3
               |       09 Vengeance Is My Name.mp3
               |       10 A Dream That Cannot Be (feat. Doro Pesch).mp3
               |       11 Back On Northern Shores.mp3
               |       12 Death In Fire 2016.mp3
               |       13 Death In Fire (Live).mp3
               |
               |-----2019 - Berserker
                       01 Fafner's Gold.mp3
                       02 Crack the Sky.mp3
                       03 Mjölner, Hammer of Thor.mp3
                       04 Shield Wall.mp3
                       05 Valkyria.mp3
                       06 Raven's Flight.mp3
                       07 Ironside.mp3
                       08 The Berserker at Stamford Bridge.mp3
                       09 When Once Again We Can Set Our Sails.mp3
                       10 Skoll and Hati.mp3
                       11 Wings of Eagles.mp3
                       12 Into the Dark.mp3
                  Если в качестве параметра в программу передается не путь к директории, а путь к txt файлу по образцу выше - прочитать файл и вывести в консоль
                  следующие данные:
                  Количество папок
                  Количество файлов
                  Среднее количество файлов в папке
                  Среднюю длинну названия файла
                  
                  
       OptionalTask 
                 Выполнить указанные действия по чтению информации из файла, ее обработке и записи в файл. При разработке для вывода результатов создавать новую директорию и файл средствами класса File.                  
              1.     Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
              2.     Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
              3.     Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.   

          
# javaStageTwo.threads
           Java.Threads
           Задание.Разработать консольное многопоточное приложение.
           Использовать возможности, предоставляемые пакетом java.util.concurrent. Все сущности, желающие получить доступ к ресурсу, должны быть потоками.
           
            Аукцион. На торги выставляется несколько лотов. Участники аукциона делают заявки. Заявку можно корректировать в сторону увеличения несколько раз 
           за торги одного лота. Аукцион определяет победителя и переходит к следующему лоту. Участник, не заплативший за лот в заданный промежуток времени, 
           отстраняется на несколько лотов от торгов.
                  
                  
        
         
    


