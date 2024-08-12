import './style/pico.min.css';
import './style/App.css';
import KorbListe from './components/KorbListe';
import KorbTotal from './components/KorbTotal';
import NeuesProdukt from './components/NeuesProdukt';

function App() {
  return (
    <div className='container-m'>
      <div className="header">
        <article>
          Navigation
        </article>
      </div>
      <div className="menu"><NeuesProdukt/></div>
      <div className="content">
        <KorbListe/>
        </div>
      <div className="footer"><article><KorbTotal/></article></div>
    </div>
  );
}

export default App;
