import React from 'react'
import Base from '../layouts/Base'
import ImageSlider from '../components/ImageSlider'
import '../assets/styles/Home.css'


const Home = () => {
  return (
    <Base>
      <div className='base-container'>
        <div>
          <ImageSlider/>
        </div>
       <div className='btn'>
        <button className='btn1'>Farmer</button>
        <button className='btn2'>Dealer</button>
       </div>
       <div>
        <p>Additionally, the WebTransport API is expected to replace the WebSocket API for many applications. WebTransport is a versatile, low-level API that provides backpressure and many other features not supported by either WebSocket or WebSocketStream, such as unidirectional streams, out-of-order delivery, and unreliable data transmission via datagrams. WebTransport is more complex to use than WebSockets and its cross-browser support is not as wide, but it enables the implementation of sophisticated solutions. If standard WebSocket connections are a good fit for your use case and you need wide browser compatibility, you should employ the WebSockets API to get up and running quickly. However, if your application requires a non-standard custom solution, then you should use the WebTransport API.</p>
       </div>
      </div>
    </Base>
    
      

   
    
  )
}

export default Home