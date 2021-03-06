void insertAfter(plistNode pNew, T theElm)
{
   plistNode pPrev, pCurrent, pNext;
   pPrev = NULL;
   pCurrent = pStart;

   while (pCurrent) {
      pNext = NextNode(pCurrent, pPrev);
      if (pCurrent->elm == theElm) {
         /* traversal is done */
         if (pNext) {
            /* fix the existing next node */
            pNext->ptrdiff =
                (plistNode) ((int) pNext->ptrdiff
                           ^ (int) pCurrent
                           ^ (int) pNew);

            /* fix the current node */
            pCurrent->ptrdiff =
              (plistNode) ((int) pNew ^ (int) pNext
                         ^ (int) pCurrent->ptrdiff);

            /* fix the new node */
            pNew->ptrdiff =
                (plistNode) ((int) pCurrent
                           ^ (int) pNext);
         break;
      }
      pPrev = pCurrent;
      pCurrent = pNext;
   }
}
