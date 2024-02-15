public class Agent {
    // TODO Make this a proper super class, this is just to demonstrate we know
    // how inheritance works and can implement it for the comment grade.
    // This is combined with our adventurer and creature extending the agent super is
    // our example of inheritance by the way, this is going to be much refactored
    // next homework
    protected String name;
    public Agent() {
        this.name = "";
    }
    public Agent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}