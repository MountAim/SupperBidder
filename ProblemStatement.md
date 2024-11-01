Problem Description:

A company, SuperBidder, has hosted an Online Auction System where any user (seller) can sell an object through an auction.
Each auction has a lowest bid limit and a highest bid limit. Any registered user (buyer) can participate in an auction and 
bid on the product. Buyers can update this bid amount or withdraw from an auction until the auction is completed. When the 
auction closes, show the winning bid using the highest unique bid.

The program should handle input of two or more auctions and a set of users participating in these. Multiple auctions can 
occur simultaneously.

New Requirements:
SuperBidder has requested that they want the option to decide the winner based on the lowest unique bid as well.

SDE 3 Feature Only:
Buyers have a limited total budget initially.
If the buyer wins the auction, their budget is reduced by the bid amount.
Any new bid exceeding the remaining budget should be rejected.
Buyers should be able to increase their budget at any point.
;
Highest Unique Bid Definition:
For a set of users A, B, C, D, E participating in auction A1, where:

A bids 50
B bids 90
C bids 100
D bids 90
E bids 70
F bids 100
Here, 70 is the highest unique bid, so E is the winner. If there is no highest unique bid by the end of the auction, there is no winner for the auction.

Functional Requirements
Add Buyer
Add Seller
Create Auction
Create/Update Bid
Withdraw Bid
Close Auction and Return Winning Bid and the Winner’s Name
Update Budget (Only for SDE 3s)
Bonus Feature
Upgrade Buyer to Preferred Buyer if they have participated in more than two auctions.
For choosing a winner: whenever there’s a tie on the winning bid, preference should be given to the preferred buyer.
If the tie is between multiple preferred buyers, fallback to the next highest bid.
Preferred status is applicable across all sellers on the platform.
Sample Test Cases
Test Case 1
ADD_BUYER("buyer1")
ADD_BUYER("buyer2")
ADD_BUYER("buyer3")
ADD_SELLER("seller1")
CREATE_AUCTION("A1", "10", "50", "seller1")
CREATE_BID("buyer1", "A1", "17")
CREATE_BID("buyer2", "A1", "15")
UPDATE_BID("buyer2", "A1", "19")
CREATE_BID("buyer3", "A1", "19")
CLOSE_AUCTION("A1")
Expected Outcome: Should give Buyer1 as the winner.
Test Case 2
ADD_SELLER("seller2")
CREATE_AUCTION("A2", "5", "20", "seller2")
CREATE_BID("buyer3", "A2", 25)
This should fail as the highest bid limit is 20 for A2.
CREATE_BID("buyer2", "A2", 5)
WITHDRAW_BID("buyer2", "A2")
CLOSE_AUCTION("A2")
Expected Outcome: No winner.
Test Case 3 (With Budget Constraint)
ADD_BUYER("buyer1", 20)

ADD_BUYER("buyer2", 20)

ADD_BUYER("buyer3", 20)

ADD_SELLER("seller1")

ADD_SELLER("seller2")

CREATE_AUCTION("A1", "10", "50", "seller1")

CREATE_AUCTION("A2", "5", "20", "seller2")

CREATE_BID("buyer1", "A1", "17")

CREATE_BID("buyer2", "A1", "15")

UPDATE_BID("buyer2", "A1", "19")

CREATE_BID("buyer3", "A1", "19")

CLOSE_AUCTION("A1")
Expected Outcome: Should give Buyer1 as the winner.

CREATE_BID("buyer1", "A1", 5)

This should fail as it exceeds the budget for buyer1.
CREATE_BID("buyer3", "A2", 25)
This should fail as the highest bid limit is 20 for A2.
CREATE_BID("buyer2", "A2", 5)
WITHDRAW_BID("buyer2", "A2")
CLOSE_AUCTION("A2")
Expected Outcome: No winner.
Expectations and Guidelines
Create sample data yourself (file, test case, or main driver program).
Code should be demo-able using a main driver program or test cases.
Modular code, with basic OO design:
Avoid jamming responsibilities into one class.
Use interfaces and contracts between methods for extensibility.
Edge cases should be handled gracefully.
Code should be legible, readable, and DRY.
Database integration is not required.
Use your own code and do not access the internet for anything except syntax.