class Geeks 
{
    public static int maxHeight(int height[], int width[], int length[], int n)
   {
       // your code here
       ArrayList<Box> boxes = new ArrayList<Box>() ; 
       for(int i = 0; i < n; i++) {
          boxes.add(new Box(height[i], Math.max(width[i], length[i]), Math.min(width[i], length[i])));
          boxes.add(new Box(width[i], Math.max(height[i], length[i]),  Math.min(height[i], length[i])));
          boxes.add(new Box(length[i],Math.max(height[i], width[i]),Math.min(height[i], width[i])));
       }
          int totalPossibleBoxes = boxes.size();
          for(int i = 0; i < totalPossibleBoxes; i++)
            boxes.get(i).area = boxes.get(i).width * boxes.get(i).depth; 
           
           
           
            Collections.sort(boxes , new Comparator<Box>(){
              public int compare(Box b1, Box b2) {
                  return b2.area - b1.area ; 
              }
          });
          int dp[] = new int[3 * n];
          for(int i = 0 ; i < dp.length; i++) {
              int val = 0;
              dp[i] = boxes.get(i).height ; 
              for(int j = 0 ; j < i; j++){
                  if(boxes.get(i).width < boxes.get(j).width && boxes.get(i).depth < boxes.get(j).depth)
                    val = Math.max(dp[j], val); 
              }
              dp[i] = val + boxes.get(i).height ;
          }
          int maxHeight = Integer.MIN_VALUE; 
          for(int i = 0; i < dp.length; i++)
            maxHeight = Math.max(dp[i], maxHeight) ; 
          return maxHeight;
       }
   static class Box {
       int height;
       int width;
       int depth;
       int area ; 
       Box(int h, int w, int d) {
           this.height = h;
           this.width = w; 
           this.depth = d; 
       }
   }
}

