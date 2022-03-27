package es.codeurjc.Flyventas.controller;

public class CounterofferRestController {
    /*
    @GetMapping("/confirmacionContraoferta/{id}")
	public String confirmCounteroffer(Model model, @PathVariable long id) {

		Optional<Product> Product = productServices.findById(id);
		if (Product.isPresent()) {
			model.addAttribute("Product", Product.get());
			return "counteroffer";
		} else {
			return "searchnotfound";
		}
	}

	@PostMapping("/counteroffer/{id}")
	public String contraoffer(Model model, HttpServletRequest request, @PathVariable long id, @RequestParam float newOffer) {

		Principal principal = request.getUserPrincipal();
		Optional<Product> Product = productServices.findById(id);
		if (Product.isPresent()) {

			Optional<User> User = userServices.findUserByEmail(principal.getName());
			counteroffers.save(new Counteroffer(Product.get(), newOffer, User.get()));

			return "redirect:/";
		} else {
			return "searchnotfound";
		}
	}

	@PostMapping("/aceptarContraoferta/{id}")
	public String acceptCounteroffer(HttpServletRequest request, @PathVariable long id) {

	 	Optional<Counteroffer> counterOffer = counterofferServices.findById(id);
	 	if(counterOffer.isPresent()) {

	 		transactions.save(new Transaction(counterOffer.get().getProduct(), counterOffer.get().getTransmitter(), counterOffer.get().getNewPrice()));
	 		counteroffers.delete(counterOffer.get());
		}
	 	return "redirect:/";
	}*/
}
