package Week6;

import java.util.HashSet;
import java.util.Iterator;

class MySet extends HashSet<String> {
    private static final long serialVersionUID = 1L;

    public MySet() {
        super();
    }

    /**
     * @return the union of the elements of this and that
     */
    public MySet union(MySet that) {
        MySet result = new MySet();

        if(that == null) {
            Iterator iter = iterator();
            while(iter.hasNext()) result.add((String)
                    iter.next());
            return result;
        }

        Iterator here = this.iterator();
        Iterator there = that.iterator();

        while(here.hasNext())
            result.add((String) here.next());
        while(there.hasNext())
            result.add((String) there.next());

        return result;
    }

    /**
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();
        if(that == null) return result;

        Iterator here = this.iterator();
        while(here.hasNext()) {
            String next = (String) here.next();
            if(that.contains(next)) result.add(next);
        }

        return result;
    }

    /**
     * @return the difference of the elements of this and that
     */
    public MySet difference(MySet that) {
        MySet result = new MySet();

        if(that == null) {
            Iterator iter = iterator();
            while(iter.hasNext())
                result.add((String) iter.next());
            return result;
        }

        Iterator here = this.iterator();
        while(here.hasNext()) {
            String next = (String) here.next();
            if(!that.contains(next)) result.add(next);
        }

        return result;
    }

    /**
     * @return the exclusive or (XOR) of the elements of this and that
     */
    public MySet exclusiveOr(MySet that) {
        MySet result = new MySet();

        if(that == null) {
            Iterator iter = iterator();
            while(iter.hasNext())
                result.add((String) iter.next());
            return result;
        }

        return difference(that).union(that.difference(this));
    }

    /**
     * @return a String representation of a MySet object
     */
    public String toString() {
        Iterator iter = iterator();
        String res = "<MySet{";

        while(iter.hasNext()) {
            res += (String) iter.next();
            if(iter.hasNext()) res += ",";
        }
        res += "}>";
        return res;
    }
}

