package youareell;

import controllers.*;

import java.net.MalformedURLException;

public class YouAreEll {

    TransactionController tt;

    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    public YouAreEll(MessageController messageController, IdController idController) {
        this.tt = new TransactionController(messageController, idController);
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = null;

            urlhandler = new YouAreEll(
                new TransactionController(
                    new MessageController(), new IdController()
            ));
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() {
        //tt.getIds();
        return tt.makecall("/ids", "GET", "");
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }

    public String MakeURLCall(String s, String get, String s1){
        ServerController svr = new ServerController();
        return svr.idGet(s);
    }


}
