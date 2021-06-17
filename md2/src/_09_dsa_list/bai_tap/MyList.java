package _09_dsa_list.bai_tap;

import java.util.Arrays;

public class MyList<E> {
    int size = 0;
    public static final int DEFAULT_CAPACITY = 10;
    public Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity: " + capacity);
        }

    }

    /**
     * method add vao 1 vi tri nhat dinh voi phan tu la element
     *
     * @param index
     * @param element
     */

    public void add(int index, E element) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(1);
        }

        if (elements[index] != null) {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
        }
        elements[index] = element;
        size++;
    }

    /**
     * trả về số lượng phần tử có trong mảng
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * trả về một mảng rỗng
     */
    public void clean() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    /**
     * thêm vào 1 phần tử vào cuối mảng
     *
     * @param element
     * @return
     */
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(1);
        }
        elements[size] = element;
        size++;
        return true;
    }

    /**
     * Giới hạn lại capacity của mảng
     *
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);

        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }

    /**
     * lay 1 phan tu o vi tri index duoc nhap vao
     *
     * @param index
     * @return
     */
    public E get(int index) {
        return (E) elements[index];
    }

    /**
     * kiem tra 1 phan tu co trong mang hay khong? neu co tra ve vi tri
     * con khong thi tra ve -1
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    /**
     * kiem tra 1 phan tu co trong mang hay khong neu co thi tra ve true va nguoc lai
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    /**
     * clone 1 ban sao cua MyList cu sang 1 Mylist moi
     *
     * @return
     */
    public MyList<E> clone() {
        MyList<E> cloneList = new MyList();
        cloneList.elements = Arrays.copyOf(this.elements, this.size);
        cloneList.size = this.size;
        return cloneList;
    }

    /**
     * xoa 1 phan tu o vi tri chi dinh, tra ve gia tri phan tu do
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Error index: " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;

    }


}








