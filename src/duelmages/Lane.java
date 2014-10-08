package duelmages;

import java.util.ArrayList;
import java.util.List;

public abstract class Lane 
{
    private List<IBehaviour> sideOne;
    private List<IBehaviour> sideTwo;
    private final IPlayer playerOne;
    private final IPlayer playerTwo;

    public Lane(IPlayer playerOne, IPlayer playerTwo)
    {
        this.sideOne = new ArrayList<>();
        this.sideTwo = new ArrayList<>();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }
    
    public void addBehaviourByPlayerOne(IBehaviour behaviour)
    {
        this.behaviourAdded(behaviour);
        this.sideOne.add(behaviour);
        behaviour.deploy(this.sideTwo, this.playerOne);
        this.cleanUpLane();
    }
    
    public void addBehaviourByPlayerTwo(IBehaviour behaviour)
    {
        this.behaviourAdded(behaviour);
        this.sideTwo.add(behaviour);
        behaviour.deploy(this.sideOne, this.playerTwo);
        this.cleanUpLane();
    }

    private void cleanUpLane()
    {
        this.sideOne.removeIf(behaviour -> behaviour.isFinished());
        this.sideTwo.removeIf(behaviour -> behaviour.isFinished());
    }

    protected abstract void behaviourAdded(IBehaviour behaviour);
}
