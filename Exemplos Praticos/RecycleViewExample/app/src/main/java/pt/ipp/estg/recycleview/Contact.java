package pt.ipp.estg.recycleview;

public class Contact {

    private String mName;
    private boolean mOnline;

    public Contact(String mName, boolean mOnline) {
        this.mName = mName;
        this.mOnline = mOnline;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }
}
