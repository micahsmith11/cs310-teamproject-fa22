package edu.jsu.mcis.cs310.tas_fa22;


public class Department {
    //Instamce Field
    private int id;
    private String description;
    private Integer terminalid;
    
    //Constructor for Department
    public Department (int id, String description, int terminalid) {
        this.id = id;
        this.description = description;
        this.terminalid = terminalid;
        
    }
    
    //Getter Methods
    public int getId() {    
        return id;
    }

    public String getDescription() {
        return description;
    }

    
    public int getTerminalid() {    
        return terminalid;
    }

    //String Output
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        s.append('#').append(id).append(' ').append('(').append(description);
        s.append(')').append(',').append(" Terminal ID: ").append(terminalid);
        
        return s.toString();
    }
}
