package edu.upi.cs.yudiwbs.uas_template;

public class DataModelFragmentSatu {
    private String type;
    private String activity;

    public DataModelFragmentSatu(String type, String activity) {
        this.type = type;
        this.activity = activity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return this.type;
    }

    public String getActivity() {
        return activity;
    }
}
