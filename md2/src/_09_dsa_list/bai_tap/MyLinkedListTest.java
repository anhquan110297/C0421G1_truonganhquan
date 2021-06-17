package _09_dsa_list.bai_tap;


public class MyLinkedListTest {

    static class Student {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Student() {
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1, "Quân1");
        Student student2 = new Student(2, "Quân2");
        Student student3 = new Student(3, "Quân3");
        Student student4 = new Student(4, "Quân4");
        Student student5 = new Student(5, "Quân5");
        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addLast(student3);
        myLinkedList.add(2, student4);
        myLinkedList.remove(3);


        for (int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }
    }


}

