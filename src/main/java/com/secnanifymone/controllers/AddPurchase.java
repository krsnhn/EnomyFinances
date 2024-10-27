//package com.secnanifymone.controllers;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@Controller
//public class AddPurchase {
//
//	
//	// Controller method to handle adding new purchases
//	@PostMapping("/addPurchase")
//	public ResponseEntity<?> addPurchase(@RequestBody Purchase purchase) {
//	    // Logic to add the purchase to the database
//	    purchaseService.addPurchase(purchase);
//	    
//	    // Retrieve updated list of recent purchases
//	    List<Purchase> recentPurchases = purchaseService.getRecentPurchases();
//	    
//	    // Return the updated list in the response
//	    return ResponseEntity.ok(recentPurchases);
//	}
//
//}

//@PostMapping("/addPurchase")
//public ResponseEntity<?> addPurchase(@RequestBody PurchaseForm purchaseForm) {
//    // Deduct the entered sum from the user's balance
//    User user = userService.getCurrentUser(); // Assuming you have a method to get the current user
//    double newBalance = user.getBalance() - purchaseForm.getSum();
//    user.setBalance(newBalance);
//    userService.updateUser(user);
//
//    // Update the corresponding category's total in the database
//    Category category = categoryService.getCategoryByName(purchaseForm.getCategory());
//    double categoryTotal = category.getTotal() + purchaseForm.getSum();
//    category.setTotal(categoryTotal);
//    categoryService.updateCategory(category);
//
//    // Save the new purchase details in the database
//    Purchase purchase = new Purchase();
//    purchase.setPurpose(purchaseForm.getPurpose());
//    purchase.setCategory(purchaseForm.getCategory());
//    purchase.setSum(purchaseForm.getSum());
//    purchase.setDate(purchaseForm.getDate());
//    purchaseService.addPurchase(purchase);
//
//    // Retrieve updated list of recent purchases
//    List<Purchase> recentPurchases = purchaseService.getRecentPurchases();
//
//    // Return the updated list in the response
//    return ResponseEntity.ok(recentPurchases);
//}
