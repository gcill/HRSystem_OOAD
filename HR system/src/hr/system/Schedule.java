
package hr.system;

public class Schedule {
    private Session session[] = new Session[100];
    private int index = 0;

    public Session[] getSession() {
        return session;
    }

    public void setSession(Session[] session) {
        this.session = session;
    }
    public void pushSession(Session session){
        this.session[index] = session;
        index++;
    }

}
