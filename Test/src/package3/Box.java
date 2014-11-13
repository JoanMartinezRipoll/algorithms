package package3;
class Box<T extends Number> {
	    // T stands for "Type"
	    private T t;

	    public void set(T t) { this.t = t; }
	    public T get() { return t; }
	}
