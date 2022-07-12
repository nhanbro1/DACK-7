const jsonServer = require('json-server')
const server = jsonServer.create()
const router = jsonServer.router('db.json')
const middlewares = jsonServer.defaults()
const bodyParser = require('body-parser');
const fs = require('fs')
const db = JSON.parse(fs.readFileSync('./db.json', 'UTF-8'))





server.use(middlewares)
server.use(jsonServer.defaults());
server.use(bodyParser.urlencoded({extended: true}))
server.use(bodyParser.json())

// get list products
server.get('/products', (req, res) => {
    res.status(200).json({
      status: 200,
      data: {
        "products" : db.products
      }
    })
  })

// get product details
server.get("/products/:id",(req,res)=>{
    const id = req.params.id ;

    const exist_id = db.products.findIndex(products => products.id == id);
    const result = db.products.filter(products =>products.id == id);
    if(exist_id !==-1){
        const status = 200;
        return res.status(status).json({status,result})
    }else {
        return res.status(401).json({
            status: 401,
            message: "id is not found!!",
          })
    }
})

// Add news orders  
server.post("/orders",(req, res)=>{
    const {id,customer} = req.body;
    const exist_id = db.products.findIndex(products => products.id === id);
    if(exist_id ===-1){
        return res.status(401).json({
            status: 401,
            message: "Book not found!!",
        })
    }

    const order_item = db.products[exist_id];

    if(true) {
        const new_order = {
          'id': db.orders.length+1,
          order_item,
          customer,
          "quantity": 1,
          "timestamp": new Date().getTime()
        }

        db.orders.push(new_order);

        fs.writeFileSync('./db.json', JSON.stringify(db), () => {
            if (err) return console.log(err);
            console.log('writing to ' + fileName);
          })
          return res.status(200).json({
            status: 200,
            message: "Success",
            data: new_order
          })
        } else {
          return res.status(401).json({
            status: 401,
            message: "Book is out of stock!!",
          })
        }

    }


)
// view order by id
server.get("order/:id",(req,res)=>{
  const id = req.params.id;

  const exist_id = db.orders.findIndex(order => order.id == id);
  if(exist_order !== -1) {
    res.status(200).json({
          status: 200,
          data: {
            'orders': db.orders[exist_order]
          }
        })
  } else {
    return res.status(401).json({
      status: 401,
      message: "Order not found!!",
    })
  }
})

// delete orderbyid
server.delete("/orders/:id",(req, res)=>{
     const order_id = req.params.id ;
     const exist_order = db.orders.findIndex(orders => orders.id == order_id)

     if(exist_order !== -1) {
        db.orders.splice(exist_order, 1);
    
        fs.writeFileSync('./db.json', JSON.stringify(db), () => {
          if (err) return console.log(err);
          console.log('writing to ' + fileName);
        })
    
        return res.status(204).json({
          status: 204,
          message: "Success"
        })
      } else {
        return res.status(401).json({
          status: 401,
          message: "Order not found!!",
        })
      }

})

server.use(router)
server.listen(3000, () => {
  console.log('JSON Server is running')
})