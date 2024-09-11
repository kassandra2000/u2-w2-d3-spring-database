package kassandrafalsitta.u2w2d3.exceptions;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(int id){
        super("L'elemento con id " + id + " non è stato trovato!");
    }
}
