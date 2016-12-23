package xyz.xandora;

public class materia {
		
	String materiaName;
	String materiaType;
	int materiaLevel;
	int materiaGrade;
	String materiaClass;
	
	public materia(String materiaName,	String materiaType, int materiaLevel, int materiaGrade, String materiaClass) {
		this.materiaClass = materiaClass;
		if (materiaLevel > 0 && materiaLevel <= 5) {
			this.materiaLevel = materiaLevel;
		} else {
			throw new IllegalArgumentException("Materia Level out of bounds.");
		}
		this.materiaType = materiaType;
		this.materiaGrade = materiaGrade;
		this.materiaName = materiaName;
	}

	public static void getMateria(materia materia) {
		String materiaClass = materia.materiaClass;
		int materiaGrade = materia.materiaGrade;
		
		getMateriaName(materiaClass, materiaGrade);
		System.out.println("Class is: " + materia.materiaClass);
		System.out.println("Level is: " + materia.materiaLevel);
		System.out.println("Type is: " + materia.materiaType);
		System.out.println("Grade # is: " + materia.materiaGrade);
		System.out.println();
	}

	public static void getMateriaName(String materiaClass, int materiaGrade){
		
		String[] materiaName = new String[8];
		
		if (materiaClass == "Fire") {

			materiaName[0] = "Fire";
			materiaName[1] = "Fire";
			materiaName[2] = "Fira";
			materiaName[3] = "Fira";
			materiaName[4] = "Firaga";
			materiaName[5] = "Firaga";
			materiaName[6] = "Firaga";
			materiaName[7] = "Firaga";
		}
		
		if (materiaClass == "Ice") {
			
			materiaName[0] = "Blizzard";
			materiaName[1] = "Blizzard";
			materiaName[2] = "Blizzara";
			materiaName[3] = "Blizzara";
			materiaName[4] = "Blizzaga";
			materiaName[5] = "Blizzaga";
			materiaName[6] = "Blizzaga";
			materiaName[7] = "Blizzaga";
		}
		
		if (materiaClass == "Lightning") {
			
			materiaName[0] = "Thunder";
			materiaName[1] = "Thunder";
			materiaName[2] = "Thundara";
			materiaName[3] = "Thundara";
			materiaName[4] = "Thundaga";
			materiaName[5] = "Thundaga";
			materiaName[6] = "Thundaga";
			materiaName[7] = "Thundaga";
		}
			
		System.out.println(materiaName[materiaGrade - 1]);
		
	}
	
}