package gameModified;

import java.util.ArrayList;
import java.util.Collections;

public class MGameTest {

	public static void main(String[] args) {
		
		ArrayList<MDragon> lstDragon = new ArrayList<>();
		
		//TODO Random 36 Dragons
		
		
		//Add dragon by random 
		for (int sz = 0; sz < 3; sz++)
		{
				for (int i = 1; i <= 3; i++)
				{
					lstDragon.add(new MWhite("White " + String.valueOf(i), MDragonSize.getSize(sz)));
					lstDragon.add(new MRed("Red " + String.valueOf(i), MDragonSize.getSize(sz)));
					lstDragon.add(new MGreen("Green " + String.valueOf(i), MDragonSize.getSize(sz)));
					lstDragon.add(new MBlack("Black " + String.valueOf(i), MDragonSize.getSize(sz)));
				}
		}
		
		
		//from Battle Round
		for (int i = 0; i < lstDragon.size() - 1; i++)
		{
			for (int j = i + 1; j < lstDragon.size(); j++)
			{
				if (battleRound(lstDragon.get(i), lstDragon.get(j)) == lstDragon.get(i))
				{
					lstDragon.get(i).addWinBattle();
				}
				else
				{
					lstDragon.get(j).addWinBattle();
				}
				
				lstDragon.get(i).ressurect();
				lstDragon.get(j).ressurect();
				
			}
		}
		
		//print using foreach of toString of every DRAGON even the subclasses
		Collections.sort(lstDragon);
		System.out.println("The order of the winner ٩( ᐛ )و \n");
		lstDragon.forEach(System.out::println);
		
	}
	
	
	
	public static MDragon battleRound(MDragon obDragon1, MDragon obDragon2)
	{
		
		int nPlayer = 0;
		//nPlayer 0 -> dragon1, nPlayer 1 -> dragon2
		
		//which dragon go first
		if (obDragon2.getInitiative() > obDragon1.getInitiative())
		{
			nPlayer = 1;
		}
		else if (obDragon2.getInitiative() == obDragon1.getInitiative())
		{
			nPlayer = (int) (Math.random() * (1 - 0 + 1) + 0);
		}
		
		while (!obDragon1.isDead() && !obDragon2.isDead())
		{
			if (nPlayer == 0)
			{
		
				for (int i = 0; i < obDragon1.getNumAttackPerTurn(); i++)
				{
					obDragon2.defend(obDragon1);
				}
			}
			
			else
			{
				for (int i = 0; i < obDragon2.getNumAttackPerTurn(); i++)
				{
					obDragon1.defend(obDragon2);
				}
			}
			
			nPlayer = 1 - nPlayer;
			//next round for the dragon, sum of 1 and 0 = 1, 1 - current dragon = next dragon
			
		}
		
		
		
		return obDragon1.isDead() ? obDragon2 : obDragon1;
		
	}

}

//🛸　　　     　🌎　°　　🌓　•　　          .°•　　　🚀 ✯
//★　  *　　　　　°　　   　　🛰 　°·　　                       🪐
//.　　　•　°                                    ★　•  ☄
//▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂


