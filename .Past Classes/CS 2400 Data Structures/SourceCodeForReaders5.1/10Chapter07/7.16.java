// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void buy(int sharesBought, double pricePerShare)
{
   StockPurchase purchase = new StockPurchase(sharesBought, pricePerShare);
   ledger.addToBack(purchase);
} // end buy

public double sell(int sharesSold, double pricePerShare)
{
   double saleAmount = sharesSold * pricePerShare;
   double totalCost = 0;

   while (sharesSold > 0)
   {
      StockPurchase transaction = ledger.removeFront();
      double shareCost = transaction.getCostPerShare();
      int numberOfShares = transaction.getNumberOfShares();

      if (numberOfShares > sharesSold)
      {
         totalCost = totalCost + sharesSold * shareCost;
         int numberToPutBack = numberOfShares - sharesSold;
         StockPurchase leftOver = new StockPurchase(numberToPutBack, shareCost);
         ledger.addToFront(leftOver); // Return leftover shares
         // Note: Loop will exit since sharesSold will be <= 0 later
      }
      else
         totalCost = totalCost + numberOfShares * shareCost;
         
      sharesSold = sharesSold - numberOfShares;
   } // end while

   return saleAmount - totalCost; // Gain or loss
} // end sell
