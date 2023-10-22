// MongoDB Playground
// Use Ctrl+Space inside a snippet or a string literal to trigger completions.

// The current database to use.
use('integration_arcitecture');

// Create a new document in the collection.
db.getCollection('test').insertOne({
    
        capped: true, // Create a capped collection
        size: 1024, // Set the maximum size of the collection (in bytes)
        max: 1000, // Set the maximum number of documents in the collection
        validator: {
          $jsonSchema: {
            bsonType: 'object',
            required: ['name', 'age'],
            properties: {
              name: {
                bsonType: 'string',
                description: 'must be a string and is required',
              },
              age: {
                bsonType: 'int',
                minimum: 18,
                description: 'must be an integer and at least 18 years old',
              },
            },
          },
        },
        collation: { locale: 'en', strength: 1 }, // Set collation options
        expireAfterSeconds: 3600, // Automatically expire documents after 1 hour (3,600 seconds)
     
      

});
