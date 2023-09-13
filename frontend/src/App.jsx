import './App.css'
import {BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'
import InvoiceComponent from './components/InvoiceComponent.jsx'
import HeaderComponent from './components/HeaderComponent.jsx'


export default function App() {
  return (
    <div className="TodoApp">
            <BrowserRouter>
                <HeaderComponent />
                <Routes>
                    <Route path='/' element={ <HeaderComponent /> } />
                    <Route path='/login' element={ <InvoiceComponent /> } />
                    {/* <Route path='*' element={<ErrorComponent /> } /> */}

                </Routes>
            </BrowserRouter>
    </div>
)
}
// function App() {
//   const [count, setCount] = useState(0)

//   return (
//     <>
//       <div>
//         <a href="https://vitejs.dev" target="_blank">
//           <img src={viteLogo} className="logo" alt="Vite logo" />
//         </a>
//         <a href="https://react.dev" target="_blank">
//           <img src={reactLogo} className="logo react" alt="React logo" />
//         </a>
//       </div>
//       <h1>Vite + React</h1>
//       <div className="card">
//         <button onClick={() => setCount((count) => count + 1)}>
//           count is {count}
//         </button>
//         <p>
//           Edit <code>src/App.jsx</code> and save to test HMR
//         </p>
//       </div>
//       <p className="read-the-docs">
//         Click on the Vite and React logos to learn more
//       </p>
//     </>
//   )
// }

// export default App
