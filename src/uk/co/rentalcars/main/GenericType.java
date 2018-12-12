package uk.co.rentalcars.main;

public class GenericType<T> {

    private T t;

    public GenericType(T t){
        this.t=t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
