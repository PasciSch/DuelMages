package duelmages;

import java.util.List;

public class AttackBehaviour extends Behaviour
{
    public AttackBehaviour(Element element, int attack)
    {
        this.setElement(element);
        this.setAttack(attack);
    }
    
    @Override
    public void deploy(List<IBehaviour> opposingBehaviours, IPlayer opposingPlayer)
    {
    }

    @Override
    public void act(List<IBehaviour> opposingBehaviours, IPlayer opposingPlayer)
    {
        
    }
}