namespace com.sap.cap.requestservice;

using {
    cuid,
    managed,
    sap.common.CodeList
} from '@sap/cds/common';

entity Services : cuid, managed {
    title       : localized String;
    description : localized String;
    category    : Association to Categories;
}

entity Categories : CodeList {
    key ID          : Integer;
        parent      : Association to Categories;
        children    : Composition of many Categories
                          on children.parent = $self;
}
