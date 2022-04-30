import {Category} from "./category.model";
import { Product } from "./product.model";

export interface User {
    id?: number;
    name: string;
    username: string;
    email: string;
    address: string;
    roles: string[];
    categoria1: Category;
    categoria2: Category;
    categoria3: Category;
    products: Product[];
}