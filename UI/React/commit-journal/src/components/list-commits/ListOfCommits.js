import mockData from '../Stub.json';
import Commit from './Commit';

const ListOfCommits = () => {
    return (mockData.commits.map((element)=>{
        return <Commit key={element.id} element={element}/>;

    })

    );
    

}

export default ListOfCommits;