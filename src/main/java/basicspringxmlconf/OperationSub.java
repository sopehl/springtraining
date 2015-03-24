package basicspringxmlconf;

/**
 * Created by semih on 15.03.2015.
 */
public class OperationSub implements Strategy {
    @Override
    public int doOperation(int x, int y) {
        return x-y;
    }
}
