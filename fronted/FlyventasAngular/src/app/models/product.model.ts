import { Category } from "./category.model";
import { User } from "./user.model";

export interface Product {
    id?: number;
    title: string;
    description: string;
    category: Category;
    price: number;
    isSold: boolean;
    image: boolean;
    user: User;
}