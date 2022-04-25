import { Product } from "./product.model";
import { User } from "./user.model";

export interface Counteroffer {
    id?: number;
    newPrice: number;
    date: Date;
    product: Product;
    transmitter: User;
    receiver: User;
}