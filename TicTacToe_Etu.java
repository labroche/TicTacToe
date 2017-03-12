import java.util.Scanner;

public class TicTacToe_Etu {

	public static int[][] plateau;
	public static int nbCoups;

	/**
	 * Fonction d'initialisation du jeu
	 */
	public static void initGame(){
		System.out.println("Jeu Tic-Tac-Toe 1 Joueur versus Ordinateur");
		plateau = new int[3][3];
		nbCoups = 0;
	}

	/**
	 * Dessin du plateau de jeu
	 * #param: aucun, lecture de la variable globale plateau
	 */
	public static void drawGame(){
		// TODO: ecrire la fonction d'affichage du plateau
	}

	/** 
	 * Fonction qui verifie si la ligne i indique la victoire
	 * (toutes les valeurs sont identiques et differentes de 0) 
	 * @param i indice de ligne
	 * @return true ssi toutes les valeurs
	 * de la ligne i sont identiques
	 */
	public static boolean ligne(int i){
		// TODO: remplacer le code suivant
		return false;
	}

	/**
	 * Fonction qui verifie si toutes les valeurs de la colonne j sont identiques
	 * @param i indice de colonne
	 * @return true ssi toutes les valeurs
	 * de la colonne i sont identiques
	 */
	public static boolean colonne(int i){
		// TODO: remplacer le code suivant
		return false;
	}

	/**
	 * Fonction qui verifie si il y a un alignement sur une des deux diagonales
	 * @return true ssi toutes les valeurs
	 * d'au moins 1 des 2 diagonales sont identiques
	 */
	public static boolean diagonale(){
		boolean diag1 = plateau[0][0] != 0 && plateau[0][0] == plateau[1][1] && plateau[0][0] == plateau[2][2];
		boolean diag2 = plateau[0][2] != 0 && plateau[0][2] == plateau[1][1] && plateau[0][0] == plateau[2][0];
		return diag1 || diag2;
	}

	/** 
	 * @return true ssi la partie est gagnee
	 * pour un des joueurs. Il suffit qu'une ligne, une colonne
	 * ou une des deux diagonales soient completees avec la meme valeur
	 * (differente de 0)
	 */
	public static boolean partieFinie(){
		// TODO: remplacer le code suivant
		return false;
	}

	/**
	 * Programe principal du jeu
	 * @param args
	 */
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		// Initialisation du jeu
		initGame();
		drawGame();
		int ligne = 0, colonne = 0;
		while (! partieFinie()){
			System.out.println("Joueur 1 joue");
			nbCoups ++;

			do {
				System.out.println("Quelle case voulez vous choisir [1,2,3][1,2,3] ?");
				ligne = Integer.parseInt(sc.nextLine());
				colonne = Integer.parseInt(sc.nextLine());
			} while (ligne <=0 || ligne > 3 || colonne <=0 || colonne >3 || plateau[ligne-1][colonne-1] != 0);
			ligne = ligne - 1;
			colonne = colonne - 1;
			
			plateau[ligne][colonne] = 1;
			drawGame();
			
			// test si partie gagnee
			if (partieFinie()) {
				System.out.println("Le joueur a gagne !");
				break;
			} else if (nbCoups == 9){
				System.out.println("Pas de vainqueur !");
				break;
			}
			
			// sinon : ordinateur joue aleatoirement
			System.out.println("Ordinateur joue");
			nbCoups ++;
			do {
				// Choix d'une position aleatoire
				ligne = (int) (Math.random() * 3);
				colonne = (int) (Math.random() * 3);
			} while (plateau[ligne][colonne] != 0);
			
			plateau[ligne][colonne] = 2;
			drawGame();
			
			// test si partie gagnee
			if (partieFinie()) {
				System.out.println("L'ordinateur a gagne !");
				break;
			} else if (nbCoups == 9){
				System.out.println("Pas de vainqueur !");
				break;
			}
		}
		System.out.println("Partie terminee. Merci d'avoir joue !");
		sc.close();
	}

}
