package xyz.xandora;

public class fusion {
	
	static int outputGrade = 0;
	static materia baseMateria;

	//The placement of the Materia has no effect on the outcome UNLESS they
	//both are of the same grade AND level.
	static void ruleOne(materia materiaOne, materia materiaTwo){
		if (materiaOne.materiaGrade == materiaTwo.materiaGrade && materiaOne.materiaLevel == materiaTwo.materiaLevel) {
			baseMateria = materiaOne;
			ruleFour(materiaOne, materiaTwo);
			System.out.print("ruleOne (base materia): ");
			materia.getMateriaName(baseMateria.materiaClass, baseMateria.materiaGrade);
		} else {
			ruleTwo(materiaOne, materiaTwo);
			System.out.println("ruleOne (base materia): Skipped, moving to ruleTwo.");
		}
		
	}

	//If the grades are the same between both Materia but their levels are
	//different, then the higher level Materia will be the base.
	static void ruleTwo(materia materiaOne, materia materiaTwo){
		if (materiaOne.materiaGrade == materiaTwo.materiaGrade){
			if (materiaOne.materiaLevel > materiaTwo.materiaLevel){
				baseMateria = materiaOne;
				ruleFour(materiaOne, materiaTwo);
				System.out.print("ruleTwo (base materia): ");
				materia.getMateriaName(baseMateria.materiaClass, baseMateria.materiaGrade);
			} else if (materiaTwo.materiaLevel > materiaOne.materiaLevel){
				baseMateria = materiaTwo;
				ruleFour(materiaOne, materiaTwo);
				System.out.print("ruleTwo (base materia): ");
				materia.getMateriaName(baseMateria.materiaClass, baseMateria.materiaGrade);
			} 
		} else {
			ruleThree(materiaOne, materiaTwo);
			System.out.println("RuleTwo (base materia): Skipped, moving to ruleThree.");
		}
	}
	
	//The higher grade Materia serves as the base between the two Materia
	//and is the determinant of the product.
	static void ruleThree(materia materiaOne, materia materiaTwo){
		if (materiaOne.materiaGrade > materiaTwo.materiaGrade){
			baseMateria = materiaOne;
			ruleFour(materiaOne, materiaTwo);
			System.out.print("ruleThree (determinant): ");
			materia.getMateriaName(baseMateria.materiaClass, baseMateria.materiaGrade);
		} else if (materiaOne.materiaGrade < materiaTwo.materiaGrade) {
			baseMateria = materiaTwo;
			ruleFour(materiaOne, materiaTwo);
			System.out.print("ruleThree (determinant): ");
			materia.getMateriaName(baseMateria.materiaClass, baseMateria.materiaGrade);
		}
	}
	
	//If the level of one of the two Materia is at Master level, the product
	//grade will increase by 1. If both are Master Materia, then the grade
	//will increase by 2.
	static void ruleFour(materia materiaOne, materia materiaTwo){
		if (materiaOne.materiaLevel == 5 && materiaTwo.materiaLevel == 5){
			outputGrade = Math.max(materiaOne.materiaGrade, materiaTwo.materiaGrade) + 2;
			System.out.print("ruleFour (outputGrade + 2): " + outputGrade + ". Materia will be: ");
			materia.getMateriaName(baseMateria.materiaClass, outputGrade);
		} else if (materiaOne.materiaLevel == 5 || materiaTwo.materiaLevel == 5){
			outputGrade = Math.max(materiaOne.materiaGrade, materiaTwo.materiaGrade) + 1;
			System.out.print("ruleFour (outputGrade + 1): " + outputGrade + ". Materia will be: ");
			materia.getMateriaName(baseMateria.materiaClass, outputGrade);
		} else {
			outputGrade = outputGrade + 0;
			System.out.print("ruleFour (outputGrade + 0): " + outputGrade + ". Materia will be: ");
			materia.getMateriaName(baseMateria.materiaClass, baseMateria.materiaGrade);
		}

	}
	
	//An item grade can determine the maximum grade of the resulting Materia.
	static void ruleFive(materia materiaOne, materia materiaTwo, item item, int itemQuantity){
		if (materiaOne.materiaGrade < item.itemGrade && materiaTwo.materiaGrade < item.itemGrade ) {
			outputGrade = Math.max(materiaOne.materiaGrade,  materiaTwo.materiaGrade) + (1 * itemQuantity);
			System.out.println("ruleFive (max. grade): " + outputGrade);
		}
	}
	
}
