import mockData from '../Stub.json';
import Commit from './Commit';

const ListOfCommits = () => {
    return (mockData.commits.map((element)=>{
       
        return(
            <div key={element.id}>
                <Commit  element={element}/>
                </div>
        ) 

    })

    );
    

}

export default ListOfCommits;