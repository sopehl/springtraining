package importkullanimi;

/**
 * Created by semih on 29.03.2015.
 */
public class ServiceImp {

    Repository repository;

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void showTheString(){
        System.out.println(repository.getString());
    }
}
