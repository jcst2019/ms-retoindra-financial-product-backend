db.products.createIndex({ uniqueCode: 1 }, { unique: true });

db.products.insertMany([
    {
        "overdraftLimit": 0.0,
        "uniqueCode": "QeCVfZKCyo+UFXLvrwmpVw==",
        "coinType": "USD",
        "type": 3,
        "name": "Checking Account",
    },
    {
        "interestRate": 1.5,
        "uniqueCode": "QeCVfZKCyo+UFXLvrwmpVw==",
        "coinType": "USD",
        "type": 1,
        "name": "Savings Account",
    },
    {
        "creditLimit": 0.0,
        "uniqueCode": "QeCVfZKCyo+UFXLvrwmpVw==",
        "coinType": "USD",
        "type": 2,
        "name": "Credit Card",
    }
]);
