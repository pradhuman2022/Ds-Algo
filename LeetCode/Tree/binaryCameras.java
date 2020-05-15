class Solution {
    public int minCameraCover(TreeNode root) {    
       NodeInfo resultNode = minCover(root) ;
       int ans = Math.min(resultNode.coveredWithOutCamera, resultNode.coveredWithCamera);
       return ans; 
    }/*
        bs sare possible ways find krlo ye krna hai.
        muje logic aagya tha but ye teen situation ni dikh ri thi muje,
        bs ye krna hai ki ek bar camera se cover kro root ko or ek bar left or right m
        camera rkh k cover krke dekho or ek bar cover na kro grandParent p chor do cover krne k liy.
    */
    public NodeInfo minCover(TreeNode root) {
        if(root == null)
            return new NodeInfo(999999, 0, 0);
        
        NodeInfo left = minCover(root.left);
        NodeInfo right = minCover(root.right);
        int leftMin = Math.min(left.coveredWithCamera, left.coveredWithOutCamera);
        int rightMin = Math.min(right.coveredWithCamera, right.coveredWithOutCamera);
        int coveredWithCamera = 1 + Math.min(left.subNodesCoveredOnly, leftMin) + Math.min(right.subNodesCoveredOnly, rightMin);
        int coveredWithOutCamera = Math.min(left.coveredWithCamera + rightMin, right.coveredWithCamera + leftMin);
        int subNodesCoveredOnly = left.coveredWithOutCamera + right.coveredWithOutCamera;
        NodeInfo newNode = new NodeInfo(coveredWithCamera, coveredWithOutCamera, subNodesCoveredOnly);
        return newNode;
    }
    class NodeInfo{
        int coveredWithCamera;
        int coveredWithOutCamera;
        int subNodesCoveredOnly;
        NodeInfo(int coveredWithCamera, int coveredWithOutCamera, int subNodesCoveredOnly) {
            this.coveredWithCamera = coveredWithCamera;
            this.coveredWithOutCamera = coveredWithOutCamera;
            this.subNodesCoveredOnly = subNodesCoveredOnly;
        }
    }   
}
