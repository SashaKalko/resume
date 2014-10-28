import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@SessionScoped
@Named(value = "threadsExample")
public class ThreadsExample implements Serializable {
    private static int x1 = 0;
    private static int x2 = 0;


    public void getNonSynhronized() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 10_000_000; x++)
                    ThreadsExample.x1++;
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 10_000_000; x++)
                    ThreadsExample.x1++;
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = x1;
        x1 = 0;
        FacesMessage message = new FacesMessage("Result of work", ": "+result);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void getSynhronized() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 10_000_000; x++)
                    inrement();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 10_000_000; x++)
                    inrement();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = x2;
        x2 = 0;
        FacesMessage message = new FacesMessage("Result of work", ": "+result);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private synchronized void inrement(){
        x2++;
    }

}