# Introduction to Programming - Final Project

Submission:

A `public` git repository must be created and maintained for the final project. The `README` file, the Git commits and their date will be evaluated. Reasonable amount of commits is required for this task.

A `.md` file with the link to the git repository should be submitted. In which, student name, student id should be shown.

A class diagram would also be added to the git repo.

Note: simple vanilla methods in classes should be created by `lombok`.

To submit the project, please submit a single txt file with the link of the `public` git repo. 

## Class1

A class of `Address` that contains

- Fields

   1. `int streetNo`
   2. `String street`
   3. `String city`
   4. `Province province`  // enum, contains abbriviations of all provinces in Canada
   5. `String postalCode`  // len of 6 

- Methods

   1. helper method `static boolean isPostalCodeValid(String postalCode)` to checks if a postcode is valid or not. The length of a postal code can only be `6`.
      1. the postcode must follow the format: `CDCDCD`, where `C` is a character, while `D` is a digit, such as `A1B2C3`.
      2. Note: this method is a static method, which means it requires a parameter of `postalCode` instead of using the field `postalCode`, the reason of this is because this method should be called in the constructor and setter, before assigning the input `postalCode` to the field `postalCode`, only valid `postalCode` will be assigned to fields.
   2. All argument Constructor, in which the method `isPostalCodeValid()` will first be called to check if the parameter `postalCode` is valid or not, if it is valid, then set all fields, while postal code with all character uppercase to the field, else set everything as `null`.
   3. toString
   4. equals
   5. getter for every field
   6. setter for every field

## Class 2

A class of `Department` that contains

- Fields

   1. `String departmentId`   // 2-digits starts with a character `D`. This id should be increased automatically.
   2. `String departmentName`
   3. `static int nextId`     // indicates the next ID that will be used

- Methods

   1. `static boolean isDepartmentNameValid(String departmentName)` // checks if a department name is valid or not, a department name should only contain letters or space
   2. Constructor with only `departmentName` // if the `departmentName` is invalid, create the object with everything as `null`;
   3. toString
   4. equals
   5. getter   // for every field
   6. setter   // for `departmentName`

## Class 3

A class of `Student` that contains

- Fields

   1. `String studentId`   // 6-digits starts with a character `S`. This id should be increased automatically.
   2. `String studentName`
   3. `Gender gender`      // MALE FEMALE
   4. `Address address`
   5. `Department department`
   6. `ArrayList<Course> registeredCourses`
   7. `static int nextId`  // indicates the next ID that will be used

- Methods

   1. `boolean registerCourse(Course course)` // registers a course, this method (1) adds the course to the student's `registeredCourses` list, (2) adds the `student` to the course's `registeredStudents` list, (3) appends a `null` for the `scores` of each assignment of the course. If the course is already registered (exists in the student's `registeredCourses` list), directly returns `false` without adding anything.
   2. `boolean dropCourse(Course course)` // drops a course, remove the course from the student's `registeredCourses` list, and remove the student from the course's `registeredStudents` list. If the course is not registered yet (not in the student's `registeredCourses` list), directly returns `false` without removing anything.
   3. Constructor with `studentName`, `gender`, `address`, and `department`, it will create a student with `studentId` automatically generated based on the `nextId`, and `registeredCourses` as empty arraylist.
   4. `toSimplifiedString` // converts a student to a simple string with only the `studentId`, the `studentName`, and `departmentName`. This method is called in `Course` `toString()`.
   5. `toString` // converts a student to a string that contains the `studentId`, the `studentName`, the `gender`, the `address` and the `department`, and the `registeredCourses` (only the `courseId`, the `courseName`, and the `departmentName`)
   6. equals
   7. getters
   8. setters

## Class 4

A class of `Assignment` that contains

- Fields

   1. `String assignmentId`   // This id should be increased automatically.
   2. `String assignmentName`
   3. `double weight`         // the sum of weights of all assignment should be 100
   4. `ArrayList<Integer> scores`
   5. `static int nextId`     // indicates the next ID that will be used

- Methods

   1. `void calcAssignmentAvg()`    // calculates the average score for the assignment.
   2. `void generateRandomScore()`  // generates random scores for all students in an assignment, the scores are generated with the following rule: Firstly generate a random number in range `[0, 10]`, then

      - if the number is `0`, then generate a random score in range `[0, 60)` for the student;
      - if the number is `1`, `2`, then generate a random score in range `[60, 70)` for the student;
      - if the number is `3`, `4`, then generate a random score in range `[70, 80)` for the student;
      - if the number is `5`, `6`, `7`, `8`, then generate a random score in range `[80, 90)` for the student;
      - if the number is `9`, `10`, then generate a random score in range `[90, 100]` for the student;

   3. `toString` // generates a string to represent an assignment, with `assignmentId`, `assignmentName`, and `weight`.

## Class 5

A class of `Course` that contains

- Fields

   1. `String courseId` // This `twoDigitCourseId` should be increased automatically, the id follows the style `C-departmentId-twoDigitCourseId`, e.g.: `C-D01-01`, `C-D01-05`
   2. `String courseName`
   3. `double credits`  // e.g.: 1.5, 2, 2.5, 3 
   4. `Department department`
   5. `ArrayList<Assignment> assignments`
   6. `ArrayList<Student> registeredStudents`
   7. `static int nextId` // indicates the next ID that will be used.

- Methods

   1. `boolean isAssignmentWeightValid()` // checks if the sum of weights of all assignments of that course equals to 100%.
   2. `boolean registerStudent(Student student)` // adds a student to the student list of the course, also add a new `null` element to each assignment of this course, and add a new `null` element for the `finalScores`.
   3. `int[] calcStudentsAverage()` // calculates the weighted average score of a student.
   4. `boolean addAssignment(String assignmentName, double weight, int maxScore)` // adds a new assignment to the course.
   5. `void generateScores()` // generates random scores for each assignment and student, and calculates the final score for each student.
   6. `void displayScores()` // displays the scores of a course in a table, with the assignment averages and student weighted average (helper methods might be required).

      ``` data
      example:
      Course: Programming 1(C-D00-01)
                              Assignment01   Assignment02   Assignment03         Exam01         Exam02    Final Score
              Ethan Collins             82             82             76             85             80             82
              Lucas Bennett             97             92             84             67             90             83
              Ava Harrington            91             68             82             83             83             82
              Average                   90             81             81             78             84
      ```

   7. `String toSimplifiedString()` // converts a course to a simple string with only the `courseId`, `courseName`, `credits`, and `departmentName`.
   8. `String toString()` // converts a course to a string that contains the `courseId`, the `courseName`, the credits, the `departmentName` the `assignments`, the `registeredStudents` (only the `studentId`, the `studentName` and the `departmentName`), and a line to show if the current `isAssignmentWeightValid` is valid or not.
   9. equals
   10. getter
   11. setter

## Class 6

A class `Util` locates in a new package `util` which contains

- Methods:

   1. `static String toTitleCase(String str)` // converts each word in a string to title case. Assume words in `str` are always separated by space, such as `Yi Wang`, `Computer Science And Math`. `str.split()` method will be used. All `studentName`, `departmentName`, `courseName` stored in a class needs to be in title case.

## Unit Testing

Test any user-defined method that can be tested.
