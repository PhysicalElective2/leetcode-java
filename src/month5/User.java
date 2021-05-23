package month5;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-17 17:13
 **/
class Node {
    Msg msg;
    Node left;
    Node right;

}

class Msg {
    public Msg(String msg) {
        this.date = null;//get now datetime
        this.msg = msg;

    }

//    User user;
    String msg;
    Date date;

}

public class User {

    public List<User> follows;
    public List<Msg> msgs;

    public User() {
        this.follows = new ArrayList<>();
        this.msgs = new ArrayList<>();

    }

    public void folow(User user) {
        follows.add(user);
    }

    public void unFollow(User user) {
        follows.remove(user);
    }

    public void senMsg(String msg) {
        msgs.add(new Msg(msg));
    }

    public List<Msg> check(int k) {
        List<Msg> msgs = new ArrayList<>(k);
        int[] readIndex = new int[this.follows.size()];
        for (int i = 0; i < readIndex.length; i++) {
            readIndex[i] = this.follows.get(i).msgs.size();
        }
        while (msgs.size() < k) {
            Msg oneMsg = null;
            int readUser =-1;
            for (int i =0 ; i < follows.size(); i++) {
                if (readIndex[i] < 0) {
                    continue;
                }
                Msg anotherMsg = follows.get(i).msgs.get(readIndex[i]);
                if(oneMsg==null||oneMsg.date.compareTo(anotherMsg.date) < 0){
                    oneMsg = anotherMsg;
                    readUser = i;
                }
            }
            readIndex[readUser]--;
            msgs.add(oneMsg);

            boolean shouldBreak = true;
            for (int i = 0; i < readIndex.length; i++) {
                if (readIndex[i] > 0) shouldBreak = false;
            }
            if (shouldBreak) break;
            //

        }
        return msgs;


    }
}
