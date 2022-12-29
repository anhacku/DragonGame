package game;

public class Black extends Dragon {
	
public String sName;

	public Black(String sName, DragonSize nSize)
	{
		super(nSize);
		this.sName = sName;
	}
	
	
	@Override
	public String toString()
	{
		return String.format("%s\n", this.sName) + super.toString();
	}



	@Override
	public void defend(Dragon obOther) {
		// TODO Auto-generated method stub
		float fAttack = obOther.getAttack();
		
		//Based on the Color of Dragon
		//Black ultimate all 100% so no need
		
		
		//Based on Dragon Size
		if (this.nSize == DragonSize.SMALL)
		{
			fAttack = (float) (fAttack * 0.7);
		}
		else if (this.nSize == DragonSize.MEDIUM)
		{
			fAttack = (float) (fAttack * 0.8);
		}
		
		
		if (fAttack - this.getDefense() >= 0)
		{
			this.setnHitPoints((int) (this.getnHitPoints() - (fAttack - this.getDefense())));
		}
		
	}

}
