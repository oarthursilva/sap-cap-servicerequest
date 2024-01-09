using {com.sap.cap.requestservice as db} from '../db/schemas';

service AdminService {
    entity Services   as projection on db.Services;
    entity Categories as projection on db.Categories;

}
