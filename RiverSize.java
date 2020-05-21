import java.util.*;

class RiverSize {
  public static List<Integer> riverSizes(int[][] matrix) {
		// process big two D array 
		// check the visit point
		// if not add in visit 
		
   List<Integer> sizes = new ArrayList<Integer>();
		boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
		for (int r = 0 ; r < matrix.length; r++){
			for(int c = 0 ; c < matrix[0].length; c++){
				if (!isVisited[r][c]){
					travelMatrix(matrix, r, c, isVisited, sizes);
				}	
			}
		}
		
    return sizes;
  }
	// will return the size of each index 2D array
	public static void travelMatrix(int[][] matrix, int r, int c, boolean[][] isVisited, List<Integer> sizes){
		int currentRiverSize = 0;
		List<Integer[]> nodeToExplore = new ArrayList<Integer[]>();
		// add to the list current  List to process util no more step 
		nodeToExplore.add(new Integer[]{r, c});
		while(!nodeToExplore.isEmpty()){
			Integer[] currentNode = nodeToExplore.get(nodeToExplore.size()-1);
			nodeToExplore.remove(nodeToExplore.size()-1);
			r = currentNode[0];
			c = currentNode[1];
			if(isVisited[r][c]){
				continue;
			}
			isVisited[r][c]= true;
			if(matrix[r][c]==0){
				continue;
			}
			currentRiverSize++;
			List<Integer[]> unVisitedNeighbors = getPossibleVisit(r , c , matrix, isVisited);
			for(Integer[] neighbor : unVisitedNeighbors){
				nodeToExplore.add(neighbor);
			}	
		}
		if(currentRiverSize >0){
			sizes.add(currentRiverSize);
		}
 		
	}
	
	public static List<Integer[]> getPossibleVisit(int r , int c , int[][] matrix, boolean[][] isVisited){
		List<Integer[]> unVisitedNeighbors  = new ArrayList<Integer[]>();
		if(r > 0 && !isVisited[r-1][c]) {unVisitedNeighbors.add(new Integer[]{r-1, c}); }
		if(r < matrix.length -1 && !isVisited[r+1][c] ){unVisitedNeighbors.add(new Integer[]{r+1, c});}
		if( c > 0 &&  !isVisited[r][c-1] ){unVisitedNeighbors.add(new Integer[]{r, c-1});}
		if(c < matrix[0].length -1 && !isVisited[r][c+1]){ unVisitedNeighbors.add(new Integer[]{r, c+1});}
		
		return unVisitedNeighbors;
	}
	
}
