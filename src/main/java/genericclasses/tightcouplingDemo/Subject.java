package genericclasses.tightcouplingDemo;

import org.junit.Test;

public class Subject {
        Topic t = new Topic();
        public void startReading(){
            t.understand();
        }
    }

