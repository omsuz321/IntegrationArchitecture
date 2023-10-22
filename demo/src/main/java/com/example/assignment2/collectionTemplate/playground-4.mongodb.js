/* global use, db */
// MongoDB Playground
// Use Ctrl+Space inside a snippet or a string literal to trigger completions.

const database = 'integration_arcitecture';
const collection = 'test';

// Create a new database.
use(database);

// Create a new collection.
db.createCollection(collection);

// The prototype form to create a collection:
/* db.createCollection( <name>,
  {
    capped: <boolean>,
    autoIndexId: <boolean>,
    size: <number>,
    max: <number>,
    storageEngine: <document>,
    validator: <document>,
    validationLevel: <string>,
    validationAction: <string>,
    indexOptionDefaults: <document>,
    viewOn: <string>,
    pipeline: <pipeline>,
    collation: <document>,
    writeConcern: <document>,
    timeseries: { // Added in MongoDB 5.0
      timeField: <string>, // required for time series collections
      metaField: <string>,
      granularity: <string>,
      bucketMaxSpanSeconds: <number>, // Added in MongoDB 6.3
      bucketRoundingSeconds: <number>, // Added in MongoDB 6.3
    },
    expireAfterSeconds: <number>,
    clusteredIndex: <document>, // Added in MongoDB 5.3
  }
)*/

db.createCollection('myCollection', {
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
 // expireAfterSeconds: 3600, // Automatically expire documents after 1 hour (3,600 seconds)
});




// More information on the `createCollection` command can be found at:
// https://www.mongodb.com/docs/manual/reference/method/db.createCollection/
